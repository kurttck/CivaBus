import { useState, useEffect } from "react";

interface Brand {
  id: string;
  name: string;
}
interface Bus {
  id: string;
  busNumber: number;
  plate: string;
  creationDate: string;
  features: string | null;
  brand: Brand;
  status: boolean;
}

function BusList() {
  const [buses, setBuses] = useState<Bus[]>([]);

  const URL_BASE = "http://localhost:8080/bus";

  const fetchBuses = async () => {
    try {
      const response = await fetch(URL_BASE);
      const data = await response.json();
      console.log(data);
      setBuses(data.content || []);
    } catch (error) {
      console.log(error);
    }
  };

  //Fetch para traer los detalles del bus seleccionado
  const fetchBusesDetails = async (id: string) => {
    try {
      const response = await fetch(`${URL_BASE}/${id}`);
      const data = await response.json();
      console.log("fetch: " + data.content);
      return data;
    } catch (error) {
      console.log("El error al traer los detalles:", error);
      return null;
    }
  };

  useEffect(() => {
    fetchBuses();
  }, []);

  async function showDetails(id: string) {
    const bus = await fetchBusesDetails(id);
    if (bus) {
      console.log(bus);

      alert(`
      N°: ${bus.busNumber}
      Placa: ${bus.plate}
      Marca: ${bus.brand.name}
      Caracteristicas: ${bus.features}
      `);
    }
  }

  return (
    <>
      <div>
        <h1>Lista de Buses</h1>
        <table border={1} width="100%">
          <thead>
            <tr>
              <th>N°</th>
              <th>Placa</th>
              <th>Marca</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {buses.map((bus) => (
              <tr key={bus.id}>
                <td>{bus.busNumber}</td>
                <td>{bus.plate}</td>
                <td>{bus.brand.name}</td>
                <td>
                  <a onClick={() => showDetails(bus.id)}>Mostrar Datos</a>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default BusList;
