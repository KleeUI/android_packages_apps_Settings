/*
 * Copyright (C) 2026 The KleeUI Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.display;

import android.content.Context;
import android.provider.Settings;

import androidx.preference.ListPreference;
import androidx.preference.Preference;

import com.android.settings.core.BasePreferenceController;

public final class LiquidGlassStrengthPreferenceController extends BasePreferenceController
        implements Preference.OnPreferenceChangeListener {
    private static final String SETTING = "klee_liquid_glass_strength";
    private static final int STANDARD = 1;
    private static final int STRONG = 2;

    public LiquidGlassStrengthPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void updateState(Preference preference) {
        final int stored = Settings.System.getInt(mContext.getContentResolver(), SETTING, STANDARD);
        ((ListPreference) preference).setValue(String.valueOf(stored == STRONG ? STRONG : STANDARD));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        final int strength;
        if (String.valueOf(STANDARD).equals(newValue)) {
            strength = STANDARD;
        } else if (String.valueOf(STRONG).equals(newValue)) {
            strength = STRONG;
        } else {
            return false;
        }
        return Settings.System.putInt(mContext.getContentResolver(), SETTING, strength);
    }
}
