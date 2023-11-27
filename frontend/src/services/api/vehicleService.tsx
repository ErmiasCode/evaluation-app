import axios from 'axios';

const apiURL = 'http://localhost:8080/api/vehicles';

const fetchVehicles = async () => {
  try {
    const response = await axios.get(apiURL);
    return response?.data?._embedded?.vehicleList || [];
  } catch (error) {
    console.error('AxiosError:', error);
    return [];
  }
};

const deleteVehicle = async (id: number) => {
  try {
    await axios.delete(`${apiURL}/${id}`);
  } catch (error) {
    console.error('AxiosError:', error);
  }
};

export { fetchVehicles, deleteVehicle };
