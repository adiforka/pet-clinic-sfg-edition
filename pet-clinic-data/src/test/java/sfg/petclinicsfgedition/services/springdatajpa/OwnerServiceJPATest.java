package sfg.petclinicsfgedition.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sfg.petclinicsfgedition.model.Owner;
import sfg.petclinicsfgedition.repositories.OwnerRepository;
import sfg.petclinicsfgedition.repositories.PetRepository;
import sfg.petclinicsfgedition.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

//mind the extension that brings in Mockito to stand in for persistence layer
@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    public static final String LAST_NAME = "Kirby";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    /*instructor says we can do this because there's a single constr. in tested class that has all these dependencies
     * alternatively, use MockitoAnnotations.initMocks() in setUp method*/
    @InjectMocks
    OwnerServiceJPA service;
    final String lastName = LAST_NAME;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        /*you can run a test w/out assertions to see if the service gets instantiated, i.e. if the dependencies get
         * mocked and injected into it*/
        Owner returnedOwner = Owner.builder().lastName(LAST_NAME).build();

        //static imports. make sure the call to repo returns our predefined object
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        //the actual test call
        Owner kirby = service.findByLastName(lastName);

        assertEquals(LAST_NAME, kirby.getLastName());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        //call using a mock
        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        //actual call (that uses the mock repo to find all and put the in returnOwnerSet)
        Set<Owner> owners = service.findAll();

        assertNotNull(returnOwnerSet);
        assertEquals(2, owners.size());
    }


    //makes sure I return a value when owner found
    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    //check if null returned from optional if owner not found
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        //this dude is just to add some owner at method call. you get the return owner back anyway through when/thenRet
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //verify the mock was used (don't need to use times() if expecting 1 time
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());

        //verify mock was used
        verify(ownerRepository).deleteById(anyLong());
    }
}