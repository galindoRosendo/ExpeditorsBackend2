package ttl.expeditors.backend.domain;

import java.time.LocalDate;

public class Student {

   public enum Status {
      FULL_TIME,
      PART_TIME,
      HIBERNATING
   }

   private int id;
   private String name;
   private LocalDate dob;
   private String email;

   private Status status = Status.FULL_TIME;   //FULL_TIME, PART_TIME, HIBERNATING

   public Student(int id, String name, LocalDate dob, String email) {
      this(id, name, dob, email, Status.FULL_TIME);
//      init(id, name, dob, email, Status.FULL_TIME);
//      this.id = id;
//      this.name = name;
//      this.dob = dob;
//      this.setEmail(email);
//
//      System.out.println("In Ctor");
   }

   public Student(int id, String name, LocalDate dob, String email, String status) {
      this(id, name, dob, email, Status.valueOf(status));
   }

   public Student(int id, String name, LocalDate dob, String email, Status status) {
//      init(id, name, dob, email, status);

      this.id = id;
      this.name = name;
      this.dob = dob;
      this.setEmail(email);
      this.status = status;

      System.out.println("In Ctor");
   }

//   private void init(int id, String name, LocalDate dob, String email, Status status) {
//      this.id = id;
//      this.name = name;
//      this.dob = dob;
//      this.setEmail(email);
//      this.status = status;
//
//      System.out.println("In Ctor");
//   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public LocalDate getDob() {
      return dob;
   }

   public void setDob(LocalDate dob) {
      this.dob = dob;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      if(email.matches(".*@.*")) {
         this.email = email;
         return;
      }
      throw new RuntimeException("Bad email format: " + email);
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }
}
