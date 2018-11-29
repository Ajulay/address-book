package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "organization_id")
   private Organization organization;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String address;

   @Column
   private String phone;

   @Column(name="active")
   private Boolean active;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Organization getOrganization() {
      return organization;
   }

   public void setOrganization(Organization organization) {
      this.organization = organization;
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
      return active;
   }

   public void setActive(Boolean active) {
      this.active = active;
   }
}
