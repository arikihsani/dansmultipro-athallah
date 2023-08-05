# Aplikasi Spring Boot

Nama: Athallah Rikza Ihsani

RDBMS yang digunakan: PostgreSQL

## Persiapan Awal
Pastikan Anda telah memiliki hal-hal berikut sebelum memulai:

1. **Java Development Kit (JDK)**: Pastikan Anda telah menginstal JDK versi yang sesuai. Aplikasi ini menggunakan **Java 11**, jadi pastikan JDK yang tersedia di sistem Anda memiliki versi yang sama.

2. **PostgreSQL Database**: Pastikan Anda memiliki server PostgreSQL yang dapat diakses, entah itu secara lokal (menggunakan localhost) atau secara remote. Anda akan memerlukan informasi tentang host, port, nama database, serta nama pengguna dan kata sandi untuk menghubungkan aplikasi ke database.

## Menjalankan Aplikasi

1. **Clone Repositori**: Mulailah dengan mengunduh atau meng-clone repositori aplikasi ke komputer Anda.

2. **Konfigurasi Database**: Buka file `application.properties` di dalam proyek Anda dan ubah pengaturan berikut sesuai dengan detail database PostgreSQL Anda:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nama_database
   spring.datasource.username=nama_pengguna
   spring.datasource.password=kata_sandi
   ```

3. **Build dan Jalankan**: Buka terminal di direktori proyek dan jalankan perintah berikut untuk membangun dan menjalankan aplikasi:

   ```bash
   ./mvnw spring-boot:run
   ```
   Anda juga dapat menjalankan aplikasi menggunakan IDE/Text editor pilihan anda seperti **Intellij IDEA** atau **VSCode**.
   
   Aplikasi akan dijalankan di `http://localhost:8080`.

## Menggunakan Swagger UI

Swagger UI adalah alat yang memungkinkan Anda untuk secara interaktif menjelajahi dan menguji API yang ada dalam aplikasi Anda.

1. **Akses Swagger UI**: Setelah aplikasi berjalan, buka browser dan pergi ke URL berikut: `http://localhost:8080/swagger-ui.html`.

2. **Jelajahi API**: Di dalam Swagger UI, Anda akan melihat daftar endpoint API yang tersedia. Klik pada endpoint yang Anda minati untuk melihat detailnya.

3. **Menguji API**: Pada halaman endpoint, klik tombol "Try it out" untuk memasuki mode pengujian. Isi parameter yang diperlukan dan klik "Execute" untuk melihat respons dari API.

## Batasan

1. Pada API create user dan login, setiap alamat email harus unik, dan password harus memiliki ketentuan minimal 6 karakter.
