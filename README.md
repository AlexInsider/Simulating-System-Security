## Secure Design Principles Through Coding

**Mode:** Asynchronous
**Task Type:** Individual Programming Activity
**Programming Language:** Java (can convert to Python if you prefer)

<hr />

✅ **ACTIVITY TITLE: "Simulating System Security: Implementing Least Privilege and Defense in Depth in Code"**

<hr />

📌 **LEARNING OUTCOMES**
By the end of this activity, students will be able to:
<ul>
  <li>Apply the **Principle of Least Privilege** by implementing role-based access.</li>
  <li>Demonstrate **Defense in Depth** by adding multiple security layers in code.</li>
  <li>Write a simple program that simulates real-world security behavior.</li>
  <li>Analyze how coding decisions affect system security.</li>
</ul>

<hr />

🖊️ **INSTRUCTIONS FOR STUDENTS**

This is an **asynchronous activity.**

Carefully follow the steps below:

<hr />

**STEP 1 — Create these classes:**

✔ **User class**

Holds username + role

(roles: student, teacher, admin)

✔ **Permission Manager class**

Implements **Least Privilege**
<ul>
  <li>student VIEW ONLY</li>
  <li>teacher VIEW + EDIT</li>
  <li>admin FULL ACCESS</li>
</ul>

✔ **SecurityLayer class**

Implements **Defense in Depth**

<ul>
  <li>Password check</li>
  <li>FA check</li>
  <li>Intrusion detection (blocks suspicious actions)</li>
</ul>

✔ **Main class**

Simulates a login + security process
