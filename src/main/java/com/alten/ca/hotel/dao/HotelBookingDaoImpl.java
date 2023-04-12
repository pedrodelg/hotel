package com.alten.ca.hotel.dao;

import com.alten.ca.hotel.model.entity.Guest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class HotelBookingDaoImpl implements HotelBookingDAO {

    private EntityManager entityManager;

    public HotelBookingDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void bookRoom(Guest guest) {

        entityManager.persist(guest);

    }

    @Override
    public List<Guest> findReservationArrivalDepartureDate(LocalDate arrivalDate, LocalDate departureDate){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Guest> query= cb.createQuery(Guest.class);
        Root<Guest> root = query.from(Guest.class);

        Predicate arrivalDatePredicate = cb.between(root.get("arrivalDate"), arrivalDate, departureDate);
        Predicate departureDatePredicate = cb.between(root.get("departureDate"), arrivalDate, departureDate);

        query.select(root).where(
                cb.or(arrivalDatePredicate, departureDatePredicate)
        );

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void cancelReservation(Guest guest) {
        entityManager.remove(guest);
    }

    @Override
    public Optional<Guest> findReservationById(int id) {

        return Optional.ofNullable(entityManager.find(Guest.class, id));

    }

    @Override
    @Transactional
    public Guest updateReservation(Guest guestUpdate) {

        return entityManager.merge(guestUpdate);
    }


}
