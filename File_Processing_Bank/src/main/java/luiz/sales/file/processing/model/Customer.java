package luiz.sales.file.processing.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Customers")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastName;
	private int score;
	
	@Id
	@Indexed(unique = true)
	private String cpf;
	
	private double amount;
}
