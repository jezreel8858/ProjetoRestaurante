package com.br.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="Gerente")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Gerente extends Usuario{

}
