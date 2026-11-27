/*
 * Copyright (C) 2026 The KleeUI Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.display;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.core.TogglePreferenceController;

public final class LiquidGlassPreferenceController extends TogglePreferenceController {
    private static final String SETTING = "klee_liquid_glass_enabled";

    public LiquidGlassPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.System.getInt(mContext.getContentResolver(), SETTING, 1) != 0;
    }

    @Override
    public boolean setChecked(boolean checked) {
        return Settings.System.putInt(mContext.getContentResolver(), SETTING, checked ? 1 : 0);
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return R.string.menu_key_display;
    }
}
