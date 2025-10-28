# Universitet Sistemi (University System)

This project manages student enrollments for courses in a university system. The system updates enrollment information in both the `Enrollment` and `Course` tables when a student registers for a course, ensuring data consistency. It handles errors such as course overcapacity and logs all actions for tracking purposes.

## Features

1. **Course Enrollment Management:**  
   Allows students to enroll in courses, updating the enrollment count in both the `Enrollment` and `Course` tables.

2. **Error Handling:**  
   In case of errors (e.g., course capacity exceeded), an exception is thrown, and the enrollment process is properly handled.

3. **Logging:**  
   Logs all actions, including successful and failed registrations, for monitoring and debugging.
---

## Tables

### Student Table

| Column Name | Description            |
|-------------|------------------------|
| id          | Unique identifier for the student |
| name        | Name of the student    |
| email       | Email address of the student |

### Course Table

| Column Name   | Description                     |
|---------------|---------------------------------|
| id            | Unique identifier for the course|
| name          | Name of the course             |
| capacity      | Maximum number of students allowed |
| enrolledCount | Current number of enrolled students |

### Enrollment Table

| Column Name   | Description                         |
|---------------|-------------------------------------|
| id            | Unique identifier for the enrollment |
| student_id    | Foreign key referencing the student |
| course_id     | Foreign key referencing the course  |
| createdAt     | Date and time the enrollment was created |

---

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/university-system.git
