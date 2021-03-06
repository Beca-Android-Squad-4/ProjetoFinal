// Generated by view binder compiler. Do not edit!
package com.example.projetofinalquad4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projetofinalquad4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentErrorBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnTryAgain;

  @NonNull
  public final ImageView imageView2;

  private FragmentErrorBinding(@NonNull LinearLayout rootView, @NonNull Button btnTryAgain,
      @NonNull ImageView imageView2) {
    this.rootView = rootView;
    this.btnTryAgain = btnTryAgain;
    this.imageView2 = imageView2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentErrorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentErrorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_error, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentErrorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_tryAgain;
      Button btnTryAgain = ViewBindings.findChildViewById(rootView, id);
      if (btnTryAgain == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      return new FragmentErrorBinding((LinearLayout) rootView, btnTryAgain, imageView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
