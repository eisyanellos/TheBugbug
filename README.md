# Student Learning Management System (SLMS)
### CSEB5223 Software Construction & Methods | Group 9: TheBugbug 

The **Student Learning Management System (SLMS)** is a digital platform developed to streamline educational interaction between students, lecturers, and administrators.It serves as a centralized hub for managing course materials, tracking student assignments, and facilitating grade distribution.

---

## The Team: TheBugbug
| Name | Student ID | Role |
| :--- | :--- | :--- |
| **Nur Batrisyia Binti Azuhaimi** | BSW01085319 | Team Leader |
| Nik Muhammad Airiel Bin Roslin | BSW01085317 | Developer |
| Danish Haikal Bin Zalipullizam | BSW01085217 | Developer |
| Muhammad Haziq Iqbal Bin Nor Azhari | BSW01085461 | Developer |

* **Lecturer/Collaborator:** Ts. Dr. Loo Yim Ling 


---

## System Design
The SLMS architecture is built around three primary actors: **Student, Lecturer, and Admin**.

### Core Use Cases 
* **UC-01 Login:** Users securely access their profiles.
* **UC-02 View Course Materials:** Students access learning resources.
* **UC-03 Submit Assignment:** Students upload their work for assessment.
* **UC-04 Upload Materials:** Lecturers add course notes and resources.
* **UC-05 Grade Submission:** Lecturers evaluate student work and provide marks.
* **UC-06 Manage Users:** Admin creates or deletes student/lecturer accounts.

---

## Software Construction Standards
To ensure a reliable and scalable system, the following standards are mandatory for all contributors.

### 1. Naming Conventions
* **Classes:** `PascalCase` (e.g., `CourseProfile`).
* **Methods:** `camelCase` (e.g., `searchCourse()`).
* **Variables:** `camelCase` (e.g., `courseName`).
* **Constants:** `UPPER_SNAKE_CASE` (e.g., `MAX_COURSES`).

### 2. Modularity & Design Principles
* **Single Responsibility:** Every function must perform only one distinct action.
* **Size Restriction:** Functions are limited to a maximum of **50 lines**.
* **Parameter Limit:** A maximum of **4 parameters** per function.
* **Decoupling:** Business logic must be kept separate from User Interface (UI) code.

### 3. Coding Style & Formatting
* **Indentation:** 4 spaces per level (no literal Tab characters allowed).
* **Line Length:** 80-120 characters to prevent horizontal scrolling.
* **Brace Style:** Open braces `{` on the same line; closing braces `}` on a new line.
* **File Encoding:** All files must be saved using **UTF-8** encoding.

---

## Continuous Integration (CI) Rules
The following GitHub workflow is mandatory to ensure project stability:

1.  **Protected Branch:** Direct pushes to the `main` branch are strictly prohibited.
2.  **Feature Branching:** All updates must occur on dedicated branches (e.g., `feature-login`).
3.  **Peer Review:** Every Pull Request (PR) requires approval from another team member.
4.  **Commit Quality:** Every commit message must be descriptive of the change made.

---

## File Header Template
Every code file must start with the following standard header comment block:

```java
/**
 * Project: Student Learning Management System (SLMS)
 * Author: [Your Name]
 * Description: [Brief description of the file's purpose]
 */
