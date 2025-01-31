package patterns.iterator.logic.impl;

import patterns.iterator.entities.MagicalCreature;
import patterns.iterator.logic.CustomIterator;

import java.util.List;

public class MagicalZooIterator implements CustomIterator<MagicalCreature> {
    private final List<MagicalCreature> creatures;
    private int position = -1;

    public MagicalZooIterator(List<MagicalCreature> creatures) {
        this.creatures = creatures;
    }

    @Override
    public boolean hasNext() {
        return position < creatures.size() - 1;
    }

    @Override
    public MagicalCreature next() {
        if (hasNext()) {
            position++;
            return creatures.get(position);
        }
        throw new IllegalStateException("There is no next element!");
    }

    @Override
    public boolean hasPrevious() {
        return position > 0;
    }

    @Override
    public MagicalCreature previous() {
        if (hasPrevious()) {
            position--;
            return creatures.get(position);
        }
        throw new IllegalStateException("There is no previous element!");
    }

    @Override
    public int getPosition() {
        return position;
    }
}