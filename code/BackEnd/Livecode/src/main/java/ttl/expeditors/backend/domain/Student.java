package ttl.expeditors.backend.domain;

import java.time.LocalDate;

public class Student {
   private int id;
   private String name;
   private LocalDate dob;
   private String email;

   public Student(int id, String name, LocalDate dob, String email) {
      this.id = id;
      this.name = name;
      this.dob = dob;
      this.setEmail(email);

      System.out.println("In Ctor");
   }

   public int getId() {
      return this.id;
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
}
