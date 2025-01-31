package patterns.iterator.collections.impl;

import patterns.iterator.collections.CustomCollection;
import patterns.iterator.entities.MagicalCreature;
import patterns.iterator.logic.CustomIterator;
import patterns.iterator.logic.impl.MagicalZooIterator;

import java.util.List;

public class MagicalZoo implements CustomCollection<MagicalCreature> {
    private final List<MagicalCreature> creatures;

    public MagicalZoo(List<MagicalCreature> creatures) {
        this.creatures = creatures;
    }

    @Override
    public CustomIterator<MagicalCreature> iterator() {
        return new MagicalZooIterator(creatures);
    }
}