package org.academiadecodigo.hackathon.persistence.model;

import java.util.Arrays;
import java.util.List;

public enum State {

    REGISTERED,
    PROFILE_TO_BE_DEFINED,
    MONITORED;

    /**
     * Lists the account types
     *
     * @return the list of account types
     */
    public static List<State> list() {
        return Arrays.asList(State.values());
    }
}
