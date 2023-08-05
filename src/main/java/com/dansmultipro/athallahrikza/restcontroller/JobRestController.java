package com.dansmultipro.athallahrikza.restcontroller;

import com.dansmultipro.athallahrikza.dto.JobDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.classgraph.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/job")
public class JobRestController {
    @GetMapping("/jobs")
    public ResponseEntity<String> getJobList() {
        RestTemplate restTemplate = new RestTemplate();
        String jobsUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        ResponseEntity<String> response = restTemplate.getForEntity(jobsUrl, String.class);
        return response;
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<String> getJobDetail(@PathVariable("id") String jobId) {
        RestTemplate restTemplate = new RestTemplate();
        String jobDetailUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + jobId;
        ResponseEntity<String> response = restTemplate.getForEntity(jobDetailUrl, String.class);
        return response;
    }
    @GetMapping("/download-jobs-csv")
    public ResponseEntity<ByteArrayResource> downloadJobListAsCsv() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String jobsUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        ResponseEntity<String> response = restTemplate.getForEntity(jobsUrl, String.class);
        String jobsJson = response.getBody();
        // Convert JSON to List<JobDTO>
        ObjectMapper objectMapper = new ObjectMapper();
        List<JobDTO> jobs = objectMapper.readValue(jobsJson, new TypeReference<List<JobDTO>>() {});
        for (JobDTO x: jobs){
            x.setDescription(x.getDescription().replace("\n", "").replace("\r", "").replace(";", ""));
        }
        // Convert List<Job> to CSV format
        String csv = jobs.stream()
                .map(job -> job.toCsvString())
                .collect(Collectors.joining("\n"));
        ByteArrayResource resource = new ByteArrayResource(csv.getBytes());

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("text/csv"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"job_list.csv\"")
                .body(resource);

    }
}
