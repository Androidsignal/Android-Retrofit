package com.example.pramukhraj.myapplication.acitvity;

import com.example.pramukhraj.myapplication.model.ContactsItem;

import java.util.List;

public interface OnClickRecycleItem {
    public void resultclick(List<ContactsItem> getContacts, int position);
}