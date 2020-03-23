package com.practicas.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.practicas.model.Car;
import com.practicas.model.constants.ExerciseConstants;
import com.practicas.service.data.DatabaseJson;

public class CarService {

	public static List<Car> getCars(int suelo, int techo) {

		// comprobamos los parámetros de entrada

		assert suelo < techo;

		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();

		int begin = suelo;
		if (begin < 0) {
			begin = 0;
		}
		int end = techo;
		if (end <= 0 || end > listCar.size()) {
			end = listCar.size();
		}

		return listCar.subList(begin, end);
	}

	public static List<Car> getCars(int suelo, int techo, Predicate<Car> p) {

		assert p != null;

		List<Car> cars = getCars(suelo, techo).stream().filter(p).collect(Collectors.toList());
		return cars;
	}

	public static List<Car> getCars(int suelo, int techo, Predicate<Car> p, CarComparator comparator) {

		List<Car> cars = getCars(suelo, techo, p);
		if (comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList());
		}

		return cars.stream().sorted().collect(Collectors.toList());
	}

	public static List<Car> getCars(int suelo, int techo, Predicate<Car> p, CarComparator comparator, int limit) {

		assert limit > 0;

		List<Car> cars = getCars(suelo, techo, p, comparator);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}

	public List<Car> getCars(int suelo, int techo, Predicate<Car> p, int limit) {
		assert limit > 0;
		List<Car> cars = getCars(suelo, techo, p);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param listCar
	 * @param suelo   primer coche que busca
	 * @param techo   ultimo coche que busca
	 * @return
	 */
	public static List<Car> marcaModeloIntervalo(int suelo, int techo) {

		if (suelo > techo) {
			return null;
		}

		List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		// Recorre n veces del coche numero "suelo" al "techo" para recoger el modelo y
		// la marca
		// de cada uno en orden

		if (suelo < 0) {
			suelo = 0;
		}

		if (techo <= 0 || techo > listCar.size()) {
			techo = listCar.size();
		}

		return listCar.subList(suelo, techo);
	}

	/**
	 * 
	 * @param listCar
	 * @param nCoches  numero de coches que busca
	 * @param potencia potencia minima para recoger la marca y el modelo
	 * @return
	 */
	public static List<Car> marcaModeloPotencia(int nCoches, int potencia) {

		if (potencia < 0) {
			return null;
		}

		List<Car> listCar = marcaModeloIntervalo(-1, -1);
		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getEngineinformation().getEnginestatistics().getHorsepower() > potencia;
			}

		};

		List<Car> listCarReturn = listCar.parallelStream().filter(p).limit(nCoches).collect(Collectors.toList());

		return listCarReturn;

	}

	/**
	 * 
	 * @param transmision define si es automatico o no
	 * @return
	 */
	public static List<Car> marcaModeloAutomaticos(ExerciseConstants.transmission transmision) {
		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		if (transmision == null) {
			return null;
		}
		String transmIntr = "";
		if (transmision.name().equals("AUTOMATIC")) {
			transmIntr = "Automatic transmission";
		} else if (transmision.name().equals("MANUAL")) {
			transmIntr = "Manual transmission";
		}

		final String fTransmision = transmIntr;

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getIdentification().getClassification().equals(fTransmision);
			}

		};
		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());
		return listCarReturn;
	}

	public static List<Car> marcaModeloTraccion(ExerciseConstants.wheel traccion) {
		if (traccion == null) {
			return null;
		}
		List<Car> listCar = marcaModeloIntervalo(-1, -1);
		String traccIntr = "";
		if (traccion.name().equals("FRONT")) {
			traccIntr = "Front-wheel drive";
		} else if (traccion.name().equals("REAR")) {
			traccIntr = "Rear-wheel drive";
		} else if (traccion.name().equals("ALL")) {
			traccIntr = "All-wheel drive";
		}

		final String fTraccion = traccIntr;

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getEngineinformation().getDriveline().equals(fTraccion);
			}

		};

		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());

		return listCarReturn;
	}

	public static List<Car> marcaModeloCombustible(ExerciseConstants.fuel combustible) {
		if (combustible == null) {
			return null;
		}
		List<Car> listCar = marcaModeloIntervalo(-1, -1);
		String combIntr = "";
		if (combustible.name().equals("DIESEL")) {
			combIntr = "Diesel fuel";
		} else if (combustible.name().equals("GASOLINA")) {
			combIntr = "Gasoline";
		}

		final String fCombustible = combIntr;

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {

				return t.getFuelinformation().getFueltype().equals(fCombustible);
			}

		};

		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());

		return listCarReturn;
	}

	public static List<Car> marcaModeloFechaOrdenado(int nCoches, int fecha, boolean orden) {

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		if (nCoches <= 0 || nCoches > listCar.size() - 1) {
			return null;
		}
		ComparadorPotencia comparaPotencia = new ComparadorPotencia(orden);
		List<Car> listCarReturn = listCar.stream().filter(car -> car.getIdentification().getYear() == fecha)
				.limit(nCoches).sorted(comparaPotencia).collect(Collectors.toList());

		return listCarReturn;
	}

	public static List<Car> modeloCaracterNumero(int pos) {

		if (pos < 0) {
			return null;
		}

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		List<Car> listCarReturn = listCar.stream().filter(car -> {
			return Character.isDigit(car.getIdentification().getId().charAt(pos));
		}).collect(Collectors.toList());
		return listCarReturn;
	}

	public static List<Car> marcaModeloHibrido(boolean hibrido) {

		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().isHybrid() == true;
			}
		};

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());

		return listCarReturn;

	}

	public static List<Car> cochesVelocidades(int velocidades) {
		if (velocidades < 0 || velocidades > 8) {
			return null;
		}
		Predicate<Car> p = new Predicate<Car>() {

			@Override
			public boolean test(Car t) {
				return t.getEngineinformation().getNumberofforwardgears() == velocidades;
			}
		};

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		List<Car> listCarReturn = listCar.stream().filter(p).collect(Collectors.toList());

		return listCarReturn;

	}

	public static List<Car> marcaModeloConsumo(int consumo, boolean orden) {

		if (consumo <= 0) {
			return null;
		}

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		ComparadorConsumo consumoComparador = new ComparadorConsumo(orden);

		List<Car> listCarReturn = listCar.stream().filter(car -> car.getFuelinformation().getCitymph() < consumo)
				.sorted(consumoComparador).collect(Collectors.toList());
		return listCarReturn;

	}

	public static List<Car> marcaModeloIncluyeCaracter(String caracteres) {

		if (caracteres.length() == 0) {
			return null;
		}

		List<Car> listCar = marcaModeloIntervalo(-1, -1);

		List<Car> listCarReturn = listCar.stream()
				.filter(car -> car.getEngineinformation().getEnginetype().contains(caracteres))
				.collect(Collectors.toList());
		return listCarReturn;
	}

}
