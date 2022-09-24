package com.sample.carmarket.screen.cars;

import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Cars;

@UiController("Cars.browse")
@UiDescriptor("cars-browse.xml")
@LookupComponent("carsesTable")
public class CarsBrowse extends StandardLookup<Cars> {
}