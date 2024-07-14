package mouda.randomseat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mouda.randomseat.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	boolean existsByNames(String names);
}
