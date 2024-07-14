package mouda.randomseat.dto;

import java.util.List;

import jakarta.validation.constraints.Min;

public record SeatAssignRequest(
	List<String> names,
	@Min(value = 1, message = "적어도 1명은 입력하세용")
	int count
) {
}
