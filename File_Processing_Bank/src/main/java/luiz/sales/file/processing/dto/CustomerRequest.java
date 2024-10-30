package luiz.sales.file.processing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	private String name;
	private String lastName;
	private String score;
	private String cpf;
	private String amount;
}
