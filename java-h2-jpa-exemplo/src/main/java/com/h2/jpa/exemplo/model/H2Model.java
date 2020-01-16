package com.h2.jpa.exemplo.model;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tabelah2")
public class H2Model {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 9)
	private Long id;

	@Column(name = "nome", length = 50)
	private String nome;

	@Column(name = "idade", length = 2)
	private Integer idade;
}
