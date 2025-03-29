package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "PersonTable")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "PeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int peid;
	
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+")
	@Size(min = 3, max = 20)
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+")
	@Size(min = 3, max = 25)
	@Column(name = "Surname")
	private String surname;
	
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
}
