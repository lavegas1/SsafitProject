import { defineStore } from 'pinia'

// Create a new store instance.
export const useStore = defineStore({
  id: 'main',
  state: () => ({
    account: {
      id: 0,
      token: null
    }
  }),
  actions: {
    setAccount(payload) {
      this.account.id = payload.id;
    },
    setToken(token) {
      this.account.token = token;
    }
  }
})
