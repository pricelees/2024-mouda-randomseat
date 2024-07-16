package mouda.randomseat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mouda.randomseat.domain.Seat;
import mouda.randomseat.domain.repository.SeatRepository;

@Service
@RequiredArgsConstructor
public class SeatService {

	private static final int NUMBER_OF_CASES = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
	private final SeatRepository seatRepository;

	public List<String> assignSeat(String names) {
		List<String> shuffled = getInitialNames(Arrays.asList(names.split(",")));
		String result;
		int trial = 1;
		do {
			Collections.shuffle(shuffled);
			result = String.join(",", shuffled);
		} while (isAlreadyAssigned(result) && trial++ < NUMBER_OF_CASES);

		seatRepository.save(Seat.builder().names(result).build());
		return Arrays.asList(result.split(","));
	}

	private List<String> getInitialNames(List<String> names) {
		List<String> result = new ArrayList<>(names);
		while (result.size() < 9) {
			result.add("빈자리");
		}
		return result;
	}

	private boolean isAlreadyAssigned(String names) {
		return seatRepository.existsByNames(names);
	}
}
