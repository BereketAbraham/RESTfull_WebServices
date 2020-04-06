package edu.miu.rest.webservices.restfulwebservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@ApiModel(description = "All details about user.")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
    @Size(min = 2 , message = "Name should have at least two character")
	@ApiModelProperty(notes = "Name should have at least two character.")
	private String name;
    @Past
	@ApiModelProperty(notes = "Birth date should be in the past.")
	private Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

	public User() {
	}

	public User(Integer id, String name, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dateOfBirth=" + dateOfBirth +
				'}';
	}
}
