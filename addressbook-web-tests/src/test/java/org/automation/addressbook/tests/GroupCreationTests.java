package org.automation.addressbook.tests;


import org.automation.addressbook.model.GroupData;
import org.automation.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        GroupData group = new GroupData().withName("test2");

        app.goTo().groupPage();
        Groups before = app.group().all();

        app.group().create(group);
        app.goTo().groupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        ;

        before.add(group);
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}