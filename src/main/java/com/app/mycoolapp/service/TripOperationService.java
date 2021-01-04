package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.BookTripModel;
import com.app.mycoolapp.dto.TripResponse;
import com.app.mycoolapp.entity.Trip;

public interface TripOperationService {

    TripResponse booktrip(BookTripModel bookTripModel);

    TripResponse canceltrip(long tripId);

    TripResponse completetrip(long tripId);
}
