package org.automation.addressbook.tests;


import org.automation.addressbook.model.GroupData;
import org.automation.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        GroupData group = new GroupData().withName("zaloopa");

        app.goTo().groupPage();
        Groups before = app.group().all();

        app.group().create(group);
        app.goTo().groupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        before.add(group);
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() throws Exception {
        GroupData group = new GroupData().withName("zaloopa'");

        app.goTo().groupPage();
        Groups before = app.group().all();

        app.group().create(group);
        app.goTo().groupPage();
        assertThat(app.group().Count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before));
    }
}