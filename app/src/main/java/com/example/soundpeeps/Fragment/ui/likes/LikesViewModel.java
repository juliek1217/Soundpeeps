package com.example.soundpeeps.Fragment.ui.likes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LikesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LikesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Likes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}