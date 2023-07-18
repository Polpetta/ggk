package com.github.polpetta.engine;

import com.google.inject.assistedinject.Assisted;

import javax.inject.Inject;
import java.util.Objects;

public class PlayerPOJO {

    private final String name;

    @Inject
    public PlayerPOJO(@Assisted String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerPOJO that = (PlayerPOJO) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PlayerPOJO{" +
               "name='" + name + '\'' +
               '}';
    }
}
