ArgumentCaptor<Car> createdCarCaptor = ArgumentCaptor.forClass(Car.class);
verify(carRepository).create(createdCarCaptor.capture());

Car createdCar = createdCarCaptor.getValue();
