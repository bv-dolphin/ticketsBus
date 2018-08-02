package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "region_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Region extends BaseEntity {
	@NotBlank(message = "error.region.regionname.isnull")
	@Size(min = 3, max = 50, message = "errors.region.regionName.value.size")
	@Column(name = "region", nullable = false, length = 50,unique = true)
	private String regionName;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_tbl")
	private Country country;

}