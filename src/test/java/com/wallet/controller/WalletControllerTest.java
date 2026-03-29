@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WalletControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void shouldCreateWallet() throws Exception {
        mockMvc.perform(post("/api/wallets")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": \"user1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value("user1"));
    }
}