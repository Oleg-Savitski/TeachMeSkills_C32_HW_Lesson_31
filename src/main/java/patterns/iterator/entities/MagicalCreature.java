package patterns.iterator.entities;

public record MagicalCreature(String name, String type, String ability) {

    @Override
    public String toString() {
        return name + " (" + type + ") - Ability -> " + ability;
    }
}