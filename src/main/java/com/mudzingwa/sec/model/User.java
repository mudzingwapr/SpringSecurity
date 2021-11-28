package com.mudzingwa.sec.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="usrtab")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer uid;
	private String username;
	private String password;
	@ElementCollection
	@CollectionTable(name="rotab",joinColumns=@JoinColumn(name="uid"))
	@Column(name="role")
	private List<String> role;


}
