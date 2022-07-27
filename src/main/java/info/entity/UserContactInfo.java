package info.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User_Details", uniqueConstraints = @UniqueConstraint(columnNames = "phone_no"))
public class UserContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="first_name")
    @NotEmpty(message = "first name should Not be empty")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "last name should Not be empty")
    private String lastName;


    @Column(name="phone_no")
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile Number, please enter 10 digit no only")
    private String phoneNo;


    //@JsonIgnore
    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "address_id")
    private Address address;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
