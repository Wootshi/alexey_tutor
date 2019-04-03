package org.automation.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    @Override
    protected Set<GroupData> delegate() {
        return delegate();
    }

    public Groups withAdded(GroupData group) {


    }
}
