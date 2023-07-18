package com.github.polpetta.UI;

import com.google.inject.AbstractModule;

public class UiDI extends AbstractModule {
    @Override
    protected void configure() {
        bind(UI.class).to(SystemUI.class);
    }
}
