package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.*;
import com.intive.trainings.gof.creational.builder.Garden.GardenFactory;

import java.util.List;

public interface HouseBuilder {
    HouseBuilder windows(int windows);
    HouseBuilder doors(int doors);
    HouseBuilder rooms(int rooms);
    HouseBuilder floors(int floors);
    HouseBuilder swimPool(SwimPool swimPool);
    HouseBuilder garage();
    HouseBuilder garden(Garden garden);
    HouseBuilder fancyStatues(List<FancyStatue> fancyStatues);
    HouseBuilder fence(Fence fence);
    HouseBuilder reset();
}
