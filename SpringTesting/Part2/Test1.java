@Test
public void getCarReturnsValidCarJson() {
        Car testCar = getTestCar();

        String result = mvc.perform(get("/api/car/1")
                .with(user("test_api").roles("API")))
                .andReturn().getResponse().getContentAsString();

        String testCarJson = objectToJson(testCar);

        assertEquals(testMabEntryJson, result);
}
