package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

   @Id
   @GeneratedValue
   private long id;

   @ManyToOne
   @JoinColumn(name = "org_id", nullable = false)
   private Organization orgId;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String address;

   @Column
   private String phone;

   @Column(name="active")
   private Boolean isActive;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Organization getOrgId() {
      return orgId;
   }

   public void setOrgId(Organization orgId) {
      this.orgId = orgId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public Boolean isActive() {
      return isActive;
   }

   public void setActive(Boolean active) {
      isActive = active;
   }
}
