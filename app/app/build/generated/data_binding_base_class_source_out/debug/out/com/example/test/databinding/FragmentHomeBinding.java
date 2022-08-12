// Generated by view binder compiler. Do not edit!
package com.example.test.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageButton imageButton2;

  @NonNull
  public final ImageButton imageButton4;

  @NonNull
  public final ImageButton imageButtonFootball;

  @NonNull
  public final TextView textViewOne;

  private FragmentHomeBinding(@NonNull FrameLayout rootView, @NonNull ImageButton imageButton2,
      @NonNull ImageButton imageButton4, @NonNull ImageButton imageButtonFootball,
      @NonNull TextView textViewOne) {
    this.rootView = rootView;
    this.imageButton2 = imageButton2;
    this.imageButton4 = imageButton4;
    this.imageButtonFootball = imageButtonFootball;
    this.textViewOne = textViewOne;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageButton2;
      ImageButton imageButton2 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton2 == null) {
        break missingId;
      }

      id = R.id.imageButton4;
      ImageButton imageButton4 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton4 == null) {
        break missingId;
      }

      id = R.id.imageButtonFootball;
      ImageButton imageButtonFootball = ViewBindings.findChildViewById(rootView, id);
      if (imageButtonFootball == null) {
        break missingId;
      }

      id = R.id.textView_one;
      TextView textViewOne = ViewBindings.findChildViewById(rootView, id);
      if (textViewOne == null) {
        break missingId;
      }

      return new FragmentHomeBinding((FrameLayout) rootView, imageButton2, imageButton4,
          imageButtonFootball, textViewOne);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
