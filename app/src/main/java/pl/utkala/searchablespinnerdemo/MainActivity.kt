/*
 * Copyright 2018 Mateusz Utkala (DonMat)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.utkala.searchablespinnerdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.utkala.searchablespinner.OnSearchableItemClick
import pl.utkala.searchablespinner.StringHintArrayAdapter

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = listOf(
            "John Doe",
            "Ellen Cunningham",
            "Carmen Walker",
            "Mike Walker",
            "Edgar Bourn",
            "Richard Robson",
            "Ralph Poe",
            "Max Smith"
        )
        searchableSpinner.showHint = true
        searchableSpinner.setSearchBoxBackground(resources.getDrawable(R.drawable.shape_rectangle_radius_light_black))
        searchableSpinner.adapter = StringHintArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            users,
            "Select Item"
        )
        searchableSpinner.onSearchableItemClick = object : OnSearchableItemClick<Any?> {
            override fun onSearchableItemClicked(item: Any?, position: Int) {
                if (position > 0) {
                    searchableSpinner.setSelection(position)
                } else {
                    searchableSpinner.setSelection(Spinner.INVALID_POSITION)
                }
            }
        }

        searchableSpinner.setCustomDialogAdapter(
            StartWithArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                users
            )
        )
    }
}
