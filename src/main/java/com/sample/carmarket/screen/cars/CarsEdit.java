package com.sample.carmarket.screen.cars;

import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Cars;

@UiController("Cars.edit")
@UiDescriptor("cars-edit.xml")
@EditedEntityContainer("carsDc")
public class CarsEdit extends StandardEditor<Cars> {
}