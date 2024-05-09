## Steps

Write this in your xml

```android
    <com.ui.components.overlay.HighlightView
        android:id="@+id/highlight_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

Write this in your Activity

```android
    val highlightView = findViewById<HighlightView>(R.id.highlight_view)
    highlightView.highlightPositions = listOf(
        HighlightPosition(x = 550.0f, y = 350.0f, r = 180.0f),
        HighlightPosition(x = 550.0f, y = 350.0f*2.5f, r = 250.0f),
        HighlightPosition(x = 550.0f, y = 350.0f*4f, r = 180.0f),
        HighlightPosition(x = 550.0f, y = 350.0f*5.25f, r = 180.0f)
    )
```

## Screenshots

![App Screenshot](https://github.com/kamranhadi/Highlighted-Circle/blob/75e0f7f9c635606e0db061196b0c7c5931e1c1e4/Screenshot_20240509_141406_SquareProgress.jpg)

