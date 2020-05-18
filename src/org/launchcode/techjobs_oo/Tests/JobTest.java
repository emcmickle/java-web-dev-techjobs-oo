package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.launchcode.techjobs_oo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JobTest {

    private static Job newJob;
    private static Job newJobTwo;
    private static Job completeJob;
    private static Job completeJobTwo;

    @Test
    public void testSettingJobId() {
        assertEquals(1, newJob.getId());
        assertEquals(2, newJobTwo.getId());
    }

    @BeforeClass
    public static void dataSetUp() {
        newJob = new Job();
        newJobTwo = new Job();
        completeJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        completeJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", completeJob.getName());
        assertEquals("ACME", completeJob.getEmployer().getValue());
        assertEquals("Desert", completeJob.getLocation().getValue());
        assertEquals("Quality control", completeJob.getPositionType().getValue());
        assertEquals("Persistence", completeJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(completeJob.getId(), completeJobTwo.getId());
    }

    @Test
    public void testJobToString() {
        assertEquals("\n" +
                "ID: 3\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n" +
                "\n", completeJob.toString());
    }
}
