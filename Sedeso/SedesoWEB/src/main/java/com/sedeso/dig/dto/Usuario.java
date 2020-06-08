package com.sedeso.dig.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Usuario implements Serializable {

	private static final long serialVersionUID = 8552733705661805440L;
	private int id;
}
